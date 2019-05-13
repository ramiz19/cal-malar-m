/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author cemr_
 */
public class SystemFiles {
    private Long file_id;
    private String file_path;
    private String file_name;
    private String file_type;

    public SystemFiles() {
    }

    public SystemFiles(Long file_id, String file_path, String file_name, String file_type) {
        this.file_id = file_id;
        this.file_path = file_path;
        this.file_name = file_name;
        this.file_type = file_type;
    }
    

    public Long getFile_id() {
        return file_id;
    }

    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }
    
    
}
