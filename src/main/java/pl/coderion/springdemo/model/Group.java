package pl.coderion.springdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String symbol;

    private String name;
}