function Task({task}) {


    const handleDeleteTask = async() => {
        // const response = await fetch(`http://localhost:8080/api/tasks/deleteTask/${id}`, {
        //     method: "PUT",
        //     headers: {
        //         "Content-Type": "application/json"
        //     },
        // })


    }

    return (
        <>
            <h2>{task.title}: {task.status}</h2>
            <h3>{task.description}</h3>
            <h6>{task.id}</h6>
            <button onClick={handleDeleteTask}>Delete task</button>
        </>
    )
}

export default Task

