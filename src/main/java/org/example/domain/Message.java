package org.example.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

import javax.persistence.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotBlank(message = "please fill message")
    @Length(max = 255,message = "message too long")
    private String text;

    private String tag;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Message() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}