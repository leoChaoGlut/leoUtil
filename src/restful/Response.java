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
	private Object result;

	public Response() {
	}

	public Response(int status, String msg, Object result) {
		this.status = status;
		this.msg = msg;
		this.result = result;
	}

	public static Response success(Object result) {
		return new Response(Status.OK.getCode(), Status.OK.getMsg(), result);
	}

	public static Response error() {
		// TODO 未完成
		return null;
	}

}
