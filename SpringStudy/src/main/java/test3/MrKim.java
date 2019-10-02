package test3;

public class MrKim implements Human{ 


	private String name;
	private Item item;

	@Override
	public void has() {
		System.out.println(name +"입니다. 다음 상품을 가지고 있습니다.");
		item.showName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
