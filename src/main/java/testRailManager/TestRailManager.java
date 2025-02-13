package testRailManager;


import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;

import java.util.List;

public class TestRailManager {
    public static void main(String[] args) {
        //Получаем экземпляр TestRail
        String testRailUrl = "https://directority.testrail.io/";
        String userName = "Samdonner@jam.ty";
        String password = "Drdg!34adg";

        TestRail myTestRail = TestRail
                .builder(testRailUrl, userName, password).applicationName("TestRailIntegration").build();

        //Список все проектов
        System.out.println("===========PROJECT LIST============");
        List<Project> projectList = myTestRail.projects().list().execute();
        for (Project project : projectList) {
            System.out.println("Project Name: " + project.getName() + "\nProjectId: " + project.getId());
        }

        //Список Suites
        System.out.println("===========Suites LIST============");
        List<Suite> suitesList = myTestRail.suites().list(1).execute();
        for (Suite suites : suitesList) {
            System.out.println("Suite Name: " + suites.getName() + "\nSuite Id: " + suites.getId());
        }

        //Список всех тест кейсов
        System.out.println("===========Suites LIST============");


        List<CaseField> caseFieldList = myTestRail.caseFields().list().execute();
        List<Case> caseList = myTestRail.cases().list(1, 1, caseFieldList).execute();

        for (Case cases : caseList) {
            System.out.println("Case Name: " + cases.getTitle() + "\n" + "Case Id: " + cases.getId());
        }
        //5,6,7,8

        //создание тест рана
        Run run = myTestRail.runs().add(2, new Run().setName("AQA TEST RUN")).execute().setSuiteId(1);
        //1- passed, 2 - blocked, 4 - retest, 5 - failed;
        List<ResultField> resultFieldList = myTestRail.resultFields().list().execute();
        myTestRail.results().addForCase(run.getId(), 9, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 10, new Result().setStatusId(2), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 11, new Result().setStatusId(4), resultFieldList).execute();
        myTestRail.results().addForCase(run.getId(), 12, new Result().setStatusId(5), resultFieldList).execute();

        //закрыть тест ран co suite
        myTestRail.runs().close(run.getId()).execute();

        //создание тест рана
        Run run2 = myTestRail.runs().add(1, new Run().setName("AQA TEST RUN2").setSuiteId(1)).execute();
        //1- passed, 2 - blocked, 4 - retest, 5 - failed;
        myTestRail.results().addForCase(run2.getId(), 5, new Result().setStatusId(1), resultFieldList).execute();
        myTestRail.results().addForCase(run2.getId(), 6, new Result().setStatusId(2), resultFieldList).execute();
        myTestRail.results().addForCase(run2.getId(), 7, new Result().setStatusId(4), resultFieldList).execute();
        myTestRail.results().addForCase(run2.getId(), 8, new Result().setStatusId(5), resultFieldList).execute();

        //закрыть тест ран
        myTestRail.runs().close(run2.getId()).execute();
    }

}
