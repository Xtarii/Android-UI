import Link from "next/link"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Link href={"./clickables/buttons"}>Buttons</Link>
    </div>)
}
