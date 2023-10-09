package com.tramhuong.product.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "FILE")
@Data
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "PRODUCT_ID", nullable = false)
    private UUID fileId;

    @Column(name = "PRODUCT_NAME")
    private String pathLocal;
}
