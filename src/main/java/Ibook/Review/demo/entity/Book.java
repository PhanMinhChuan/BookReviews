package Ibook.Review.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "book")
public class Book {

    //@Indexed
    @Id
    private long id;

    @Field("name")
    private String name;

    @Field("idCat")
    private List<Long> idCat;

    @Field("idAuthor")
    private List<Long> idAuthor;

    @Field("description")
    private String description;

    @Field("detail")
    private String detail;

    @Field("image")
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getIdCategories() {
        return idCat;
    }

    public void setIdCategories(List<Long> idCat) {
        this.idCat = idCat;
    }

    public List<Long> getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(List<Long> idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Book () {
        super();
    }

    public Book (long id, String name, List<Long> idCat, List<Long> idAuthor, String description, String detail, String image) {
        this.id = id;
        this.name = name;
        this.idCat = idCat;
        this.idAuthor = idAuthor;
        this.description = description;
        this.detail = detail;
        this.image = image;
    }
}