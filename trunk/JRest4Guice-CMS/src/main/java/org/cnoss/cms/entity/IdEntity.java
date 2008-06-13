/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cnoss.cms.entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import org.jrest4guice.jpa.EntityAble;

/**
 * 具有默认ID的Entity类.
 *
 *
 */
@MappedSuperclass
public abstract class IdEntity implements EntityAble<Long>, Serializable {

	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}