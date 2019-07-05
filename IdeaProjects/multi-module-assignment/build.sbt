name := "multi-module-assignment"

version := "0.1"

scalaVersion := "2.13.0"
lazy val root = (project in file("."))
lazy val entity = project in file("entity")

