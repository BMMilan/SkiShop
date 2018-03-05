package entity;
// Generated Aug 25, 2017 11:33:04 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Brend generated by hbm2java
 */
@Entity
@Table(name="brend"
    ,catalog="ski_oprema"
)
public class Brend  implements java.io.Serializable {


     private Integer brendId;
     private String naziv;
     private Set<Proizvod> proizvods = new HashSet<Proizvod>(0);

    public Brend() {
    }

	
    public Brend(String naziv) {
        this.naziv = naziv;
    }
    public Brend(String naziv, Set<Proizvod> proizvods) {
       this.naziv = naziv;
       this.proizvods = proizvods;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="brend_id", unique=true, nullable=false)
    public Integer getBrendId() {
        return this.brendId;
    }
    
    public void setBrendId(Integer brendId) {
        this.brendId = brendId;
    }

    
    @Column(name="naziv", nullable=false, length=45)
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="brend")
    public Set<Proizvod> getProizvods() {
        return this.proizvods;
    }
    
    public void setProizvods(Set<Proizvod> proizvods) {
        this.proizvods = proizvods;
    }




}


