package pl.lab.app;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;


public class Main {

    public static void listAllComplaints() {
        Client client = ClientBuilder.newClient();
        String complaints =
                client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                                "api/complaints")
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        System.out.println("Complaints: " + complaints);
        client.close();
    }

    public static void listAllOpenComplaints() {
        Client client = ClientBuilder.newClient();
        String complaints =
                client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                                "api/complaints?status=open")
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        System.out.println("Open Complaints: " + complaints);
        client.close();
    }

    public static void getComplaintById() {
        Client client = ClientBuilder.newClient();
        String complaint =
                client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                                "api/complaints/452")
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        System.out.println("Complaint: " + complaint);
        client.close();
    }

    public static void modifyComplaint() {
        Client client = ClientBuilder.newClient();
        String complaint =
                client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                                "api/complaints")
                        .request(MediaType.APPLICATION_JSON)
                        .put(Entity.json("{\"id\": 452, \"complaintDate\": \"2021-04-23\", " +
                                "\"complaintText\": \"Please fix a tap in room 234\", " +
                                "\"author\": \"Marvin Doherty\", \"status\": \"closed\"}"),
                                String.class);
        System.out.println("Modified Complaint: " + complaint);
        client.close();
    }

    public static void main(String[] args) {
        listAllComplaints();
        getComplaintById();
        modifyComplaint();
        listAllOpenComplaints();
    }
}
