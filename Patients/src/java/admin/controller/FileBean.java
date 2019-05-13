/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import entity.FileDao;
import entity.SystemFiles;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author cemr_
 */
@Named(value="dosyalar")
@SessionScoped
public class FileBean implements Serializable{
    
    private Part file;
    private SystemFiles system_file;
    private List<SystemFiles> fileList;
    private FileDao fileDao;
    
    private String uploadPath = "C:\\Users\\cemr_\\Downloads\\Documents\\ppp";
    
    public void upload(){
        try{
            //fileupload....
            InputStream input = file.getInputStream();
            file.getSubmittedFileName();
            File f = new File(uploadPath);
            Files.copy(input, f.toPath(), REPLACE_EXISTING);
            
            //file rename
            String newFileName = new SimpleDateFormat("dd-MM-yyyy_hhmmss").format(new Date());
            String extension = f.getName().substring(f.getName().lastIndexOf("."));
            newFileName +=extension;
            File newFile=new File(uploadPath+newFileName);
            f.renameTo(newFile);
            
            ///////insert into db.//////
            SystemFiles sf=new SystemFiles();
            sf.setFile_path(newFile.getParent());
            sf.setFile_name(newFile.getName());

            sf.setFile_type(file.getContentType());

            this.getFileDao().insert(sf);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public SystemFiles getSystem_file() {
        return system_file;
    }

    public void setSystem_file(SystemFiles system_file) {
        this.system_file = system_file;
    }

    public List<SystemFiles> getFileList() {
        this.fileList=this.getFileDao().list();
        return fileList;
    }

    public void setFileList(List<SystemFiles> fileList) {
        this.fileList = fileList;
    }

    public FileDao getFileDao() {
        if(this.fileDao==null)
            this.fileDao=new FileDao();
        return fileDao;
    }

    public void setFileDao(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
    
}
