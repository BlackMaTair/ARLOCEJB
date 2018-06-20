package model.entities;


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.JoinColumn;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import model.refs.Messages;
import model.refs.entities.AbstractEntity;


@SuppressWarnings("serial")


//CDI
@Dependent

//JPA
@Entity
@Table(name="CIBLE")
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Cible extends AbstractEntity{
	
	@Getter
	@Setter
	@Pattern(regexp = "[A-Za-z0-9]*")
	@NotNull(message= Messages.ERREUR_DESCRIPTIF_ACTIVITE)
	@Column(name="IDENTIFIANT")
	String descriptif;
	
	@Getter
	@Setter
	@JoinColumn(name="IDENTITE")
	Identite identitePrinpal;
	
	@Getter
	@Setter
	@Column(name="DATE_NAISSANCE")
	LocalDate DateNaissance;
	
	@Getter
	@Setter
	@Column(name="COMMUN_NAISSANCE")
	String LieuNaissance;
	
	@Getter
	@Setter
	@Column(name="NATIONALITE")
	String Nationalite;
	
	@Setter
	@OneToMany
	List<Identite> lstIdentiteSecondaire;
	
	public List<Identite> getLstIdentiteSecondaire(){
		return Collections.unmodifiableList(lstIdentiteSecondaire);
	}
	
	@Setter
	@OneToMany
	List<Alerte> lstAlerte;
	
	public List<Alerte> getLstAlerte(){
		return Collections.unmodifiableList(lstAlerte);
	}
	
	@Setter
	@OneToMany( mappedBy = "cible", cascade = CascadeType.PERSIST )
	List< Faire > lstFaire;
	
	public List<Faire> getLstFaire() {
		return Collections.unmodifiableList(lstFaire);
	}
	
	
	@Setter
	@OneToMany( mappedBy = "cible", cascade = CascadeType.PERSIST )
	List< Connaitre > lstConnaitre;
	
	public List<Connaitre> getLstConnaitre() {
		return Collections.unmodifiableList(lstConnaitre);
	}
	
	@Setter
	@OneToMany( mappedBy = "cibleConnu", cascade = CascadeType.PERSIST )
	List< Connaitre > lstConnu;
	
	public List<Connaitre> getLstConnu() {
		return Collections.unmodifiableList(lstConnu);
	}
	
	@Setter
	@OneToMany( mappedBy = "cible", cascade = CascadeType.PERSIST )
	List< Suivre > lstSuivre;
	
	public List<Suivre> getLstSuivre() {
		return Collections.unmodifiableList(lstSuivre);
	}
	
	@Setter
	@OneToMany( mappedBy = "cible", cascade = CascadeType.PERSIST )
	List< Restreindre > lstRestreindre;
	
	public List<Restreindre> getLstRestreindre() {
		return Collections.unmodifiableList(lstRestreindre);
	}
	
	@Setter
	@ManyToMany
	@JoinTable(name="CONCERNER", joinColumns=@JoinColumn(name="CIBLE_ID"),inverseJoinColumns=@JoinColumn(name="DOCUMENT_ID"))
	List<Document> lstDocument;
	
	public List<Document> getLstDocument() {
		return Collections.unmodifiableList(lstDocument);
	}
	
}