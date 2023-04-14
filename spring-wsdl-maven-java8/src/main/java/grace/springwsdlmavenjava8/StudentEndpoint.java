package grace.springwsdlmavenjava8;

import grace.springwsdlmavenjava8.generated.StudentDetailsRequest;
import grace.springwsdlmavenjava8.generated.StudentDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {
    private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";

    private StudentRepository studentRepository;

    @Autowired
    public StudentEndpoint(StudentRepository StudentRepository) {
        this.studentRepository = StudentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
        StudentDetailsResponse response = new StudentDetailsResponse();
        response.setStudent(StudentRepository.findStudent(request.getName()));

        return response;
    }
}
