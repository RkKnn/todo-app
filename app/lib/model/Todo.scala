package lib.model

import ixias.model._
import java.time.LocalDateTime

import Todo._
import lib.persistence.db.StateType
case class Todo(
    id: Option[Id],
    category_id: Long,
    title: String,
    body: String,
    state: StateType,
    updatedAt: LocalDateTime = NOW,
    createdAt: LocalDateTime = NOW
) extends EntityModel[Id]

object Todo {
  val Id = the[Identity[Id]]
  type Id = Long @@ Todo
  type WithNoId = Entity.WithNoId[Id, Todo]
  type EmbeddedId = Entity.EmbeddedId[Id, Todo]

  def apply(categoryId: Long, title: String, body: String, state: StateType): WithNoId = {
    new Entity.WithNoId(new Todo(
      None, categoryId, title, body, state
    ))
  }
}