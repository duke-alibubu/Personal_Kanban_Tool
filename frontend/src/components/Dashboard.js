import React, { Component } from 'react'
import ProjectItem from './project/ProjectItem'
import CreateProjectButton from './project/CreateProjectButton'

export default class Dashboard extends Component {
    render() {
        return (
            <div>

                <div className="projects">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12">
                                <h1 className="display-4 text-center">Projects</h1>
                                <br />
                                <CreateProjectButton />
                                <br />
                                <hr />

                                {/* <!-- Project Item Component --> */}
                                <ProjectItem />
                                {/* <!-- End of Project Item Component --> */}

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}