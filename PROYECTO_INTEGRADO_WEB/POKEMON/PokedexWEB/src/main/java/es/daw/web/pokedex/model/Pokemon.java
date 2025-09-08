package es.daw.web.pokedex.model;

public class Pokemon {
	private String base_experience;
	private Integer height;
	private Integer id;
	private String name;
	private Sprite sprites;
	
	public String getBase_experience() {
		return base_experience;
	}
	public void setBase_experience(String base_experience) {
		this.base_experience = base_experience;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sprite getSprites() {
		return sprites;
	}
	public void setSprite(Sprite sprites) {
		this.sprites = sprites;
	}
	@Override
	public String toString() {
		return "Pokemon [base_experience=" + base_experience + ", height=" + height + ", id=" + id + ", name=" + name
				+ ", sprite=" + sprites + "]";
	}
	
	

}
