package org.bupt.minisemester.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "book_uploaded")
@TableName("book_uploaded")
public class BookUploaded implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId("bookid")
    private int bookid;

    @NotEmpty(message = "标题不能为空")
    @TableField("title")
    private String title;

    @TableField("description")
    private String description;

    @TableField("author")
    private String author;

    @TableField("noveltype")
    private String noveltype;

    @OneToMany(mappedBy = "book_uploaded", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChapterUploaded> chapterlist;

    // Getters and Setters
    public int getbookid() {
        return bookid;
    }

    public void setbookid(int book_id) {
        bookid = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNoveltype() {
        return noveltype;
    }

    public void setNoveltype(String noveltype) {
        this.noveltype = noveltype;
    }
}
