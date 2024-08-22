package io;

import core.AppException;

public class OutputHandler {

    public static void printAppExceptionMessage(AppException e) {
        System.out.println(e.getMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printDefaultExceptionMessage(Exception e) {
        printMessage("알 수 없는 오류로 인해 시스템이 종료 됩니다.");
        printMessage("############# [DEBUG] Traceback Logging ############");
        System.out.println(e.getMessage());
    }

    public void gameStartCommentPrint() {
        System.out.println("##################################");
        System.out.println("#\t\t\t\t숫자 야구 게임 시작!\t\t\t\t#");
        System.out.println("##################################");
        System.out.println();
    }

    public void questionToUserAboutInputNumber() {
        System.out.print("숫자를 입력 해주세요: ");
    }

    public void gameEndCommentPrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        System.out.print("> ");
    }
}
