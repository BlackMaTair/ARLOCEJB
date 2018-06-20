package model.entities;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
@Table(name="EXECUTANT")
@NoArgsConstructor

@FieldDefaults(level=AccessLevel.PRIVATE)
public class Executant extends AbstractEntity{
	
	@Getter
	@Setter
	@Pattern(regexp = "[A-Za-z]*")
	@NotNull(message= Messages.ERREUR_NOM_EXECUTANT)
	@Column(name="NOM")
	String nom;
	
	@Getter
	@Setter
	@Pattern(regexp = "[A-Za-z]*")
	@NotNull(message= Messages.ERREUR_PRENOM_EXECUTANT)
	@Column(name="PRENOM")
	String prenom;
	
	@Setter
	@OneToMany
	List<Commentaire> lstCommentaire;
	
	public List<Commentaire> getLstCommentaire() {
		return Collections.unmodifiableList(lstCommentaire);
	}
	
	
	@Setter
	@OneToMany( mappedBy = "executant", cascade = CascadeType.PERSIST )
	List< Suivre > lstSuivre;
	
	public List<Suivre> getLstSuivre() {
		return Collections.unmodifiableList(lstSuivre);
	}
	
	
	@Setter
	@OneToMany( mappedBy = "executant", cascade = CascadeType.PERSIST )
	List< Restreindre > lstRestreindre;
	
	public List<Restreindre> getLstRestreindre() {
		return Collections.unmodifiableList(lstRestreindre);
	}
	
}