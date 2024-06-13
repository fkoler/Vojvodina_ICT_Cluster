package com.iktobuka.homework.security;

public class Views {

	public static class WorkerView {}

	public static class LeaderView extends WorkerView {}

	public static class DirectoryView extends LeaderView {}
}
