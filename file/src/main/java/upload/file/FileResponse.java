package upload.file;

import java.util.Date;

public class FileResponse {
    private String id;
    private String name;
    private Long size;
    private String url;
    private String contentType;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public Date getDate(){
        return date;}

    public void setDate(Date date){
        this.date = date;}

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
