package test.entityjpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JesonTest entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "JESON_TEST")
public class JesonTest implements java.io.Serializable {

    // Fields
    private Integer userid;
    private String name;
    private String password;

    // Constructors
    /** default constructor */
    public JesonTest() {
    }

    /** minimal constructor */
    public JesonTest(Integer userid) {
        this.userid = userid;
    }

    /** full constructor */
    public JesonTest(Integer userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    // Property accessors
    @Id
    @Column(name = "USERID", unique = true, nullable = false, insertable = true, updatable = true, precision = 20, scale = 0)
    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PASSWORD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}