package lab.requests.backing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import lab.requests.data.RequestRepository;
import lab.requests.entities.Request;

import java.time.LocalDate;
import java.util.List;

@RequestScoped
@Named
@Transactional
public class RequestsList {
    @Inject
    private RequestRepository requestRepository;

    @Size(min=3, max=60, message = "{request.size}")
    private String newRequest;

    private HtmlDataTable requestsDataTable;

    public String addRequest() {
        Request request = new Request();
        request.setRequestText(newRequest);
        request.setRequestDate(LocalDate.now());
        requestRepository.create(request);
        setNewRequest("");
        return "requestsList?faces-redirect=true";
    }

    public String deleteRequest() {
        Request request = (Request) requestsDataTable.getRowData();
        requestRepository.remove(request);
        return "requestsList?faces-redirect=true";
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public String getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }
}
