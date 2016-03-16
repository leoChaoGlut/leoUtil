package restful;
/**
 * 
 * @author "leo"
 * @Description resful 返回值
 * @date 2016年3月15日 下午9:49:58
 */
public class Response {

	private int status;
	private String msg;
	private String result;

	public Response() {
	}

	public Response(int status, String msg, String result) {
		this.status = status;
		this.msg = msg;
		this.result = result;
	}

	public static Response success(String jsonMsg) {
		return new Response(Status.OK.getCode(), Status.OK.getMsg(), jsonMsg);
	}

	public static Response error() {
		// TODO 未完成
		return null;
	}

}
