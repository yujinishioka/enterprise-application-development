package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ITEM_TESTE")
@SequenceGenerator(sequenceName="SQ_TAB_ITEM_TESTE", name="itemTeste", allocationSize=1)
public class ItemTeste {
	
	@Id
	@Column(name="cd_item_teste")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemTeste")
	private Integer id;
	
	@Column(name="descricao_item_teste", nullable=false, length=500)
	private String descricao;
	
	private CasoTeste casoTeste;

}
