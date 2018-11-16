package com.utunan.pojo.community;

/**
 * 板块-Plate
 */
public class Plate {
	//板块ID
	private Long plateId;
	//版块名称
	private String plateName;
	//上级板块ID
	private Long praentPlateId;

	public Long getPlateId() {
		return plateId;
	}

	public void setPlateId(Long plateId) {
		this.plateId = plateId;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	public Long getPraentPlateId() {
		return praentPlateId;
	}

	public void setPraentPlateId(Long praentPlateId) {
		this.praentPlateId = praentPlateId;
	}

	@Override
	public String toString() {
		return "Plate{" +
				"plateId=" + plateId +
				", plateName='" + plateName + '\'' +
				", praentPlateId=" + praentPlateId +
				'}';
	}
}
