package advisor;

public class MessageBeanImpl implements MessageBean {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		
		System.out.println("안녕하세요 " + name);
	}

}
