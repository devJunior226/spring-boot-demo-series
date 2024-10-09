package training.backend.demo.student_school.revision;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * Go to http://localhost:8080/hello/.
     * @return the sentence.
     */
    @GetMapping(path = "/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello() {
        return "Hello World! From test controller";
    }

    /**
     * localhost:8080/hello/RAMDE Juldas.
     * @param userName
     * @return the sentence with the name passed in the url
     */
    @GetMapping("/hello/{user-name}")
    @ResponseStatus(HttpStatus.OK)
    public String getPathVariable(@PathVariable("user-name") final String userName) {
        return "The path variable is " + userName;
    }

    /**
     * localhost:8080/hello-request-params/?user-firstname=Juldas & user-lastname=RAMDE.
     * @param firstname
     * @param lastname
     * @return the sentence with the names passed in the url
     */
    @GetMapping("/hello-request-params")
    @ResponseStatus(HttpStatus.OK)
    public String getRequestParams(
            @RequestParam("user-firstname") final String firstname,
            @RequestParam(value = "user-lastname", required = false) final String lastname
    ) {
        return "My paths variable are " + firstname + " " + lastname;
    }

    /**
     * Send the statement with the message.
     * @param message
     * @return the statement
     */
    @PostMapping(value = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String postMessage(@RequestBody final String message) {
        return "My post message is: " + message;
    }

    /**
     * Post an order.
     * @param order
     * @return the posted order
     */
    @PostMapping("/post-order")
    @ResponseStatus(HttpStatus.CREATED)
    public String postOrder(@RequestBody final Order order) {
        return "My post order is: " + order.toString();
    }

    /**
     * Post an order in record format.
     * @param orderRecord
     * @return the order
     */
    @PostMapping("/post-order-record")
    @ResponseStatus(HttpStatus.CREATED)
    public String postOrderRecord(@RequestBody final OrderRecord orderRecord) {
        return "My post order record is: " + orderRecord.toString();
    }

}






















