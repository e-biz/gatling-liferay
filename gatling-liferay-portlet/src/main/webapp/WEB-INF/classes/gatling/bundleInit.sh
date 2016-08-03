#!/bin/bash

# Generated destination directories
simulationDir=user-files/simulations/liferay/simulations
scenarioDir=user-files/simulations/liferay/scenarios
feederDir=user-files/data/feeders

# Copies all the scala files
mkdir -p $GATLING_HOME/$simulationDir
mkdir -p $GATLING_HOME/$scenarioDir
cp com/ebusiness/liferay/simulations/* $GATLING_HOME/$simulationDir
cp com/ebusiness/liferay/scenarios/* $GATLING_HOME/$scenarioDir

# Copies all the feeders
mkdir -p $GATLING_HOME/$feederDir
cp com/ebusiness/liferay/feeders/* $GATLING_HOME/$feederDir
