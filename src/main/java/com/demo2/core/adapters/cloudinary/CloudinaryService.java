package com.demo2.core.adapters.cloudinary;

import com.demo2.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

        DataResult<Map<String, String>> upload(MultipartFile file);
        DataResult<Map> delete(String id) throws IOException;

}
