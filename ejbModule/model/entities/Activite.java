package model.entities;


import java.util.Collections;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="ACTIVITE")
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Activite extends AbstractEntity{
	
	@Getter
	@Setter
	@Pattern(regexp = "[A-Za-z0-9]*")
	@NotNull(message= Messages.ERREUR_DESCRIPTIF_ACTIVITE)
	@Column(name="DESCRIPTIF")
	String descriptif;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="TYPE_ACTIVITE")
	TypeActivite typeActivite;
	
	@Setter
	@OneToMany
	@JoinColumn(name="COMMENTAIRE")
	List<Commentaire> lstCommentaire;
	
	public List<Commentaire> getLstCommentaire() {
		return Collections.unmodifiableList(lstCommentaire);
	}
	
	@Setter
	@OneToMany( mappedBy = "activite", cascade = CascadeType.PERSIST )
	List< Faire > lstFaire;
	
	public List<Faire> getLstFaire() {
		return Collections.unmodifiableList(lstFaire);
	}
	
	
	@Setter
	@OneToMany( mappedBy = "activite", cascade = CascadeType.PERSIST )
	List< SeSituer > lstSeSituer;
	
	public List<SeSituer> getLstSeSituer() {
		return Collections.unmodifiableList(lstSeSituer);
	}
	
}