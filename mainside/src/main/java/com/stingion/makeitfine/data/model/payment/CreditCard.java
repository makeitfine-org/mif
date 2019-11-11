/*
 * Created in scope of "Make it fine" project
 */

package com.stingion.makeitfine.data.model.payment;

import com.stingion.makeitfine.data.model.Bank;
import com.stingion.makeitfine.data.model.Ordering;
import com.stingion.makeitfine.data.model.user.Contact;
import com.stingion.makeitfine.data.model.utils.CardType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.util.Set;

/**
 * Created on 12.06.17.
 */
@Entity
@Table(name = "CREDIT_CARD")
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"orders", "bank", "contact"})
@Getter
@Setter
public class CreditCard {

    @TableGenerator(
            name = "CreditCard_gen",
            table = "SEQUENCES",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER",
            pkColumnValue = "CREDIT_CARD_SEQUENCE",
            allocationSize = 1)
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CreditCard_gen")
    private Integer id;

    @Column(name = "NUMBER", unique = true)//todo:think of 16 digits number (Special type for it)
    private Long number;

    @Column(name = "TYPE", nullable = false, columnDefinition = "enum('MasterCard','Visa')")
    @Enumerated(EnumType.STRING)
    private CardType type;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ordering> orders;
}