import React from 'react'
import { Link } from 'react-router-dom'

const NotFoundPage = () => {
  return (
    <div className='container'>
      <div className='row'>
        <div className='col-md-12 text-center'>
          <samp className='display-1'>404</samp>
          <div className='mb-4 lead'>
            Opps! We can't seem to find the page you are looking for.
          </div>
          <Link to='/home' className='btn btn-link'>Back to home</Link>
        </div>
      </div>
    </div>
  )
}

export default NotFoundPage