package homework.archive.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Documents implements Comparable<Documents> {

    int folderId;// папки
    int documentId;// документа
    private String name; //название
    private String url;
    private LocalDateTime date; // дата документа

    public Documents(int folderId, int documentId, String name, String url, LocalDateTime date) {
        this.folderId = folderId;
        this.documentId = documentId;
        this.name = name;
        this.url = url;
        this.date = date;
    }

    public int getFolderId() {
        return folderId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "folderId=" + folderId +
                ", documentId=" + documentId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documents documents = (Documents) o;
        return folderId == documents.folderId && documentId == documents.documentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folderId, documentId);
    }

    @Override
    public int compareTo(Documents o) {
        int res = Integer.compare(this.folderId,o.folderId);
        return res!=0 ? res :Integer.compare(this.documentId, o.documentId);
    }
}
