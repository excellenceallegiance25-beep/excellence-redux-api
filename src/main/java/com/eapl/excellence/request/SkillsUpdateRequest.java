package com.eapl.excellence.request;

import java.util.List;

public class SkillsUpdateRequest {

	private List<SkillUpdateRequest> updates;
	private List<SkillAddRequest> adds;
	private List<Integer> deletes;

	SkillsUpdateRequest() {
	}

	public SkillsUpdateRequest(List<SkillUpdateRequest> updates, List<SkillAddRequest> adds, List<Integer> deletes) {
		super();
		this.updates = updates;
		this.adds = adds;
		this.deletes = deletes;
	}

	public List<SkillUpdateRequest> getUpdates() {
		return updates;
	}

	public void setUpdates(List<SkillUpdateRequest> updates) {
		this.updates = updates;
	}

	public List<SkillAddRequest> getAdds() {
		return adds;
	}

	public void setAdds(List<SkillAddRequest> adds) {
		this.adds = adds;
	}

	public List<Integer> getDeletes() {
		return deletes;
	}

	public void setDeletes(List<Integer> deletes) {
		this.deletes = deletes;
	}

	@Override
	public String toString() {
		return "SkillsUpdateRequest [updates=" + updates + ", adds=" + adds + ", deletes=" + deletes + "]";
	}

}
