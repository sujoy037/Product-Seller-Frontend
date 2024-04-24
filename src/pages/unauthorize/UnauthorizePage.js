import React from 'react'
import { Link } from 'react-router-dom'

const UnauthorizePage = () => {
  return (
    <div className='container'>
    <div className='row'>
      <div className='col-md-12 text-center'>
        <samp className='display-1'>401</samp>
        <div className='mb-4 lead'>
          Unauthorize! Access to this resource denied.
        </div>
        <Link to='/home' className='btn btn-link'>Back to home</Link>
      </div>
    </div>
  </div>
  )
}

export default UnauthorizePage