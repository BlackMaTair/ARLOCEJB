package model.entities;

import java.time.LocalDate;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name="COMMENTAIRE")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Commentaire extends AbstractEntity{
	
	@Pattern(regexp = "[A-Za-z0-9]*")
	@NotNull(message= Messages.ERREUR_CONTENU_COMMENTAIRE)
	@Column(name="CONTENU")
	String contenu;
	
	@Pattern(regexp = "[A-Za-z0-9]*")
	@NotNull(message= Messages.ERREUR_TITRE_COMMENTAIRE)
	String titre;
	
	@Column(name="DATE_PUBLICATION")
	LocalDate datePublication;
	
	
	@JoinColumn(name="EXECUTANT")
	Executant auteur;
	
	
	@JoinColumn(name="ACTIVITE")
	Activite activite;
	
}