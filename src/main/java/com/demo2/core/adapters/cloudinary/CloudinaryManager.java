package com.demo2.core.adapters.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.demo2.core.utilities.results.DataResult;
import com.demo2.core.utilities.results.ErrorDataResult;
import com.demo2.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class CloudinaryManager implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryManager() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name", "dwho6snsj");
        valuesMap.put("api_key", "679842825351723");
        valuesMap.put("api_secret", "RGUYsli2HwTeA4CBKV1Gxr2vQL8");
        cloudinary = new Cloudinary(valuesMap);
    }

    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yüklenemedi");
        }
    }

    public DataResult<Map> delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}

