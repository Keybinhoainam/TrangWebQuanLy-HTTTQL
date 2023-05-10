package Nhom4.Service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import Nhom4.Exception.StorageException;
import Nhom4.Exception.StoreFileNotFoundException;





public interface StorageService {

	void init() throws StorageException;

	void delete(String storedFilename) throws IOException;

	Path load(String filename);

	Resource loadAsResource(String filename) throws StoreFileNotFoundException;

	void store(MultipartFile file, String storedFilename) throws StorageException;

	String getStoredFilename(MultipartFile file, String id);


}
