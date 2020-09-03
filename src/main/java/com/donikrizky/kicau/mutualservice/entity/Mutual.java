package com.donikrizky.kicau.mutualservice.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.donikrizky.kicau.mutualservice.config.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mutual")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "createdDate", "modifiedBy", "modifiedDate" }, allowGetters = true)
@ApiModel(description = "All details about Mutual. ")
@SQLDelete(sql = "UPDATE mutual SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class Mutual extends Auditable<String> {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mutual_id_seq_gen")
	@SequenceGenerator(name = "mutual_id_seq_gen", sequenceName = "mutual_id_seq", allocationSize = 1)
	@ApiModelProperty(notes = "Mutual DB id")
	private Integer mutualId;

	@NotNull
	private Integer userId;

	@NotNull
	private Integer followerId;
		
	private boolean deleted;

}
