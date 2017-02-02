#!/bin/bash

procs=$(ps aux | grep selenium )
# procNames=$(echo "$procs" | awk -F ' ' '{ print $11 }' | sort)
# procIds=$(echo "$procs" | awk -F ' ' '{ print $2 }' | sort)


get_procs(){

	echo "$procs" | while read line
	do
		name=$(echo "$line" | awk -F ' ' '{ print $11 }')

		if ! [[ $name == *"grep"* ]]
			then
				procId=$(echo "$line" | awk -F ' ' '{ print $2 }')
				kill_proc $procId
		fi
	done

	echo "!"
	echo "Grid configuration was shut down"
	echo "!"
}

kill_proc(){
	procId=$1

	kill -9 "$procId"
}

checkIfNeeded(){
	response=$(curl -Isv localhost:4444 2> /dev/null) 

	# echo "$response"
	if [[ $response == *"HTTP/1.1 200 OK"* ]]
		then
			get_procs
		else
			echo "!"
			echo "Grid configuration is already down..."
			echo "!"
	fi
}

checkIfNeeded