package restful;

/**
 * 
 * @author leo
 * @date 2016年3月16日 下午1:33:11
 * @description http返回码
 */
public enum Status {

	OK(200, "成功"), NOT_MODIFIED(304, "文件未修改"), BAD_REQUEST(400, "错误请求"), UNAUTHORIZED(
			401, "未授权"), FORBIDDEN(403, "请求被拒绝"), NOT_FOUND(404, "请求的页面不存在"), INTERNAM_SERVER_ERROR(
			500, "服务器内部错误");

	private int code;
	private String msg;

	private Status(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
