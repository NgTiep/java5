package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data @AllArgsConstructor
public class Report {
    @Id int cid;
    long productCount;
}
