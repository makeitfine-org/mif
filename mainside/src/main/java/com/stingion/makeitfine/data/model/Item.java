/*
 * Created in scope of "Make it fine" project
 */

package com.stingion.makeitfine.data.model;

import com.stingion.makeitfine.data.model.utils.ModelConstants;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.util.Set;

/**
 * Created on 12.06.17.
 */
@Entity
@Table(name = "ITEM")
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "header"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @TableGenerator(
            name = "Item_gen",
            table = "SEQUENCES",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER",
            pkColumnValue = "ITEM_SEQUENCE",
            allocationSize = 1)
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Item_gen")
    private Integer id;

    @Column(name = "HEADER", unique = true)
    @Length(min = ModelConstants.MIN_BANK_NAME_LENGTH, max = ModelConstants.MAX_BANK_NAME_LENGTH)
    private String header;

    @Column(name = "PRICE")
    private Double price;

    @OneToMany(mappedBy = "item")
    private Set<Order> order;

    public Item(String header, Double price) {
        this.header = header;
        this.price = price;
    }
}