//package ErrorHandling;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import javax.servlet.ServletContext;
//import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.StatusType;
//import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//
//@Provider
//public class GeneralExceptionMapper implements ExceptionMapper<Exception> {
//
//    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    @Context
//    ServletContext context;
//
//    @Override
//    public Response toResponse(Exception ex) {
//
//        String msg = "There is no person with the given ID. Exception: " + ex.getMessage();
//        int statusCode = 404;
//        if (ex instanceof WebApplicationException) {
//
//            Response res = ((WebApplicationException) ex).getResponse();
//            if (res != null) {
//                StatusType type = res.getStatusInfo();
//                msg = type.getReasonPhrase();
//                statusCode = type.getStatusCode();
//            }
//        }
//        ErrorMessage err = new ErrorMessage(msg, statusCode);
//        return Response.status(404)
//                .entity(gson.toJson(err))
//                .type(MediaType.APPLICATION_JSON).
//                build();
//
//    }
//}