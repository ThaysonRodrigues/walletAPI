package com.wallet.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WalletItemDTO {
	
	private Long id;
	
	@NotNull(message = "Insira o ID da carteira")
	private Long wallet;
	
	@NotNull(message = "Informe uma data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date date;
	
	@NotNull(message = "Informe um tipo")
	@Pattern(regexp = "^(ENTRADA|SAIDA)$", message = "Para o tipo somente são aceitos os valores ENTRADA OU SAIDA")
	private String type;
	
	@NotNull(message = "informe uma descrição")
	private String description;
	
	@NotNull(message = "Informe um valor")
	private BigDecimal value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWallet() {
		return wallet;
	}

	public void setWallet(Long wallet) {
		this.wallet = wallet;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
