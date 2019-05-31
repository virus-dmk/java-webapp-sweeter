package com.itransition.webapp.domain;

import javax.persistence.*;


@Entity
@Table(name = "chaptr")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "compos_id")
    private Composition composition;

    private String chapter_name;
    private Integer chapter_number;
    @Column(columnDefinition = "LONGTEXT")
    private String chapter_text;

    public Chapter(){
    }

    public Chapter(String chapter_name, Integer chapter_number, String chapter_text, Composition composition) {
        this.chapter_name = chapter_name;
        this.chapter_number = chapter_number;
        this.chapter_text = chapter_text;
        this.composition = composition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public Integer getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(Integer chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getChapter_text() {
        return chapter_text;
    }

    public void setChapter_text(String chapter_text) {
        this.chapter_text = chapter_text;
    }


}
