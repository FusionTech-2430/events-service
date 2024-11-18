package co.allconnected.fussiontech.eventsservice.services;

import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseService {

    @Transactional
    public String uploadImg(String imageName, String extension, MultipartFile imageFile) throws IOException {
        InputStream inputStream = imageFile.getInputStream();
        Bucket bucket = StorageClient.getInstance().bucket();
        bucket.create("event_photos/"+imageName, inputStream, "image/"+extension);
        return bucket.get("event_photos/"+imageName)
                .signUrl(360, java.util.concurrent.TimeUnit.DAYS).toString();
    }

    @Transactional
    public void deleteImg(String imageName) {
        Bucket bucket = StorageClient.getInstance().bucket();
        bucket.get("event_photos/"+imageName).delete();
    }

    @Transactional
    public String createUser(String email, String password) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);

        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        return userRecord.getUid();
    }

    @Transactional
    public void deleteUser(String uid) throws FirebaseAuthException {
        FirebaseAuth.getInstance().deleteUser(uid);
    }

    @Transactional
    public void disableUser(String uid) throws FirebaseAuthException {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
                .setDisabled(true);
        FirebaseAuth.getInstance().updateUser(request);
    }

    @Transactional
    public void updateUser(String uid, String email, String password) throws FirebaseAuthException {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid);
        if (email != null)
            request.setEmail(email);
        if (password != null)
            request.setPassword(password);
        FirebaseAuth.getInstance().updateUser(request);
    }
}
