package com.michal.springboot.domain;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Mike on 2017-07-24.
 */
@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private byte[] file;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", file=" + Arrays.toString(file) +
                ", name='" + name + '\'' +
                '}';
    }
}
